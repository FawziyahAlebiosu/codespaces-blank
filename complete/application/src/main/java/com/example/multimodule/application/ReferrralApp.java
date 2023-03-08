package com.example.multimodule.application;

import com.example.multimodule.service.MyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = "com.example.multimodule")
@RestController
public class ReferralApp {

	private final MyService myService;

	public ReferralApp (MyService myService) {
		this.myService = myService;
	}

	@RequestMapping("/referrer/{{unique-url}}")
	@ResponseBody
	public String updateReferreeData(
		@RequestParam("name") String name,
		@@RequestParam("email") String email,
		@RequestParam("resume") String resume,
		@RequestParam("note") String note
	) {
		Referree currentReferree = new Referree(name, email, resume, note);
		Referrer.updateReferreeData(currentReferree);
		Referrer.getAllReferreeData();

	}

	@RequestMapping("/referrer/name/referrees")
	@ResponseBody
	public String getAllReferees(
		@RequestParam("uniqueLink") String url,
	){
		Referrer.getAllReferreeData();

	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}

@RequestMapping(
  value = "/ex/foos", 
  method = RequestMethod.GET, 
  produces = "application/json"
