package org.joker.tv.controller.web;

import org.joker.tv.model.front.web.ActivationResult;
import org.joker.tv.model.front.web.DeviceDto;
import org.joker.tv.model.front.web.SubscriptionType;
import org.joker.tv.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SubscriptionController {

	@Autowired
	private SubscriptionService subscriptionService;

	@GetMapping("/activation")
	public String activation(Model model) {
		return "modules/activation/form";
	}

	@PostMapping("/activation")
	@ResponseBody
	public ActivationResult activateProduct(DeviceDto device, Model model) {
		return subscriptionService.activateIPTVSubscription(device);
	}

	@GetMapping("/iptv/subscriptions")
	public String iptvSubscriptions(Model model) {
		model.addAttribute("subscriptions", subscriptionService.getAllIPTVSubscriptions());
		model.addAttribute("subscriptionType", SubscriptionType.IPTV);
		return "modules/subscriptions/main";
	}

	@GetMapping("/sharing/subscriptions")
	public String sharingSubscriptions(Model model) {
		model.addAttribute("subscriptions", subscriptionService.getAllSharingSubscriptions());
		model.addAttribute("subscriptionType", SubscriptionType.SHARING);
		return "modules/subscriptions/main";
	}
}