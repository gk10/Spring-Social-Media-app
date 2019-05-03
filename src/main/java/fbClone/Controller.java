package main.java.fbClone;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import main.java.fbClone.Repos.*;

import java.sql.Timestamp;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.security.Principal;


@RestController
public class Controller {

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private UsersRepo uRepo;

	@Autowired
	private AuthoritiesRepo author;
	
	@Autowired 
	private GroupsRepo groups;
	
	@Autowired 
	private FriendsRepo friendRepo;
	
	@Autowired 
	private MemberRepo mRepo;
	
	@GetMapping("/")
	public ModelAndView home(Principal principal) {
		ModelAndView model = new ModelAndView("index.html");
		model.addObject("msg", postRepo.friendPosts(uRepo.recentSearch(principal.getName())));
		return model;
	}
	
	@GetMapping("/users")
	public ModelAndView users() {
		ModelAndView model = new ModelAndView("users.html");
		model.addObject("msg", uRepo.users());
		return model;
	}
	
	@GetMapping("/groups")
	public ModelAndView groups() {
		ModelAndView model = new ModelAndView("group.html");
		model.addObject("msg", groups.groups());
		return model;
	}
	
	@PostMapping("/cGroup")
	public RedirectView postG(@RequestParam("name") String name) {
		Groups group = new Groups();
		group.setName(name);
		groups.save(group);
		RedirectView re = new RedirectView();
		re.setUrl("/groups");
		return re;
	}
	
	@GetMapping("/friends")
	public ModelAndView friends(Principal principal) {
		ModelAndView model = new ModelAndView("users.html");
		model.addObject("msg", uRepo.friends(uRepo.recentSearch(principal.getName())));
		return model;
	}

	@PostMapping("/posts")
	public ModelAndView post(@RequestParam("task") String task, Principal principal) {
		ModelAndView model = new ModelAndView("index.html");
		if (!task.isEmpty()) {
			String name = principal.getName();
			Posts post = new Posts();
			post.setName(name);
			post.setPost(task);
			postRepo.save(post);
		}
		model.addObject("msg", postRepo.friendPosts(uRepo.recentSearch(principal.getName())));
		return model;
	}
	
	@PostMapping("/post")
	public RedirectView postM(Principal p,@RequestParam("task") String task, @RequestParam("user") String user) {
		RedirectView re = new RedirectView();
		Posts post = new Posts();
		String name = p.getName();
		post.setName(name);
		post.setPost(task);
		post.setUser(uRepo.recentSearch(user));
		postRepo.save(post);
		re.setUrl("/groups");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~ " + user);
		return re;
		
	}

	@PostMapping("/search")
	public ModelAndView search(@RequestParam("search") String search) {
		ModelAndView model = new ModelAndView("index.html");
		model.addObject("msg", postRepo.recentSearch(search));
		return model;
	}

	@GetMapping("/users/{user}")
	public ModelAndView user(@PathVariable("user") String user) {
		ModelAndView model = new ModelAndView("postPage.html");
		
		model.addObject("msg", postRepo.userSearch(user));		
		
		
		
		return model;
	}
	
	@GetMapping("/friend/{user}")
	public RedirectView friend(@PathVariable("user") String user, Principal p) {
		ModelAndView model = new ModelAndView("generic.html");
		Friends friend = new Friends();
		friend.setFriend(uRepo.recentSearch(user));
		friend.setUser(uRepo.recentSearch(p.getName()));
		friendRepo.save(friend);
		friend.setFriend(uRepo.recentSearch(p.getName()));
		friend.setUser(uRepo.recentSearch(user));
		friendRepo.save(friend);
		RedirectView re = new RedirectView();
		re.setUrl("/");
		return re;
	}
	
	@GetMapping("/groups/join/{group}")
	public RedirectView jGroup(@PathVariable("group") String group, Principal p) {
		RedirectView re = new RedirectView();
		re.setUrl("/");
		
		Member member = new Member();
		member.setgroupid(groups.id(group));
		member.setuid(uRepo.recentSearch(p.getName()));
		mRepo.save(member);
		
		return re;
	}
	
	@GetMapping("/groups/{group}")
	public ModelAndView pGroup(@PathVariable("group") String group, Principal p) {
		ModelAndView model= new ModelAndView("postPage.html");
		model.addObject("msg", "wow");
		return model;
	}
	
	@GetMapping("/register")
	public ModelAndView register() {
		ModelAndView model = new ModelAndView("register.html");
		
		return model;
	}
	
	@PostMapping("/login")
	public RedirectView login(@RequestParam("username") String name, @RequestParam("password") String pass)
	{		
		Users users = new Users();
		Authorities auth = new Authorities();
		users.setName(name);
		users.setPass(pass);
		users.setEnabled(true);
		uRepo.save(users);		
		auth.setName(name);
		auth.setAuthority("ROLE_USER");
		author.save(auth);
		RedirectView re = new RedirectView();
		re.setUrl("/");
		return re;
	}
	
}
