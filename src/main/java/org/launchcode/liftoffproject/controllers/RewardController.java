package org.launchcode.liftoffproject.controllers;

import org.launchcode.liftoffproject.data.RewardRepository;
import org.launchcode.liftoffproject.models.Reward;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("rewards")
public class RewardController {

    @Autowired
    private RewardRepository rewardRepository;

    @GetMapping
    public String displayAllRewards(Model model) {
        model.addAttribute("title","All Rewards");
        model.addAttribute("rewards", rewardRepository.findAll());
        return "rewards/index";
    };

    @GetMapping("create")
    public String renderCreateRewardForm(Model model) {
        model.addAttribute("title","New Reward");
        model.addAttribute(new Reward());
        return "rewards/create";
    };

    @PostMapping("create")
    public String processCreateRewardForm(@ModelAttribute @Valid Reward newReward, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title","New Reward");
            model.addAttribute(new Reward());
            return "rewards/create";
        }
        rewardRepository.save(newReward);
        return "redirect:";
    }

}