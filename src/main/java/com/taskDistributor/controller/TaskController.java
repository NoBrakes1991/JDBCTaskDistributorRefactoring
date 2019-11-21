package com.taskDistributor.controller;

import com.taskDistributor.entity.Task;
import com.taskDistributor.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class TaskController {

    @Autowired
    public TaskService taskService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder, Locale locale, HttpServletRequest request) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("uniqAssignee", UniqAssigneeService.getUniqAssignee(taskService.findAll()));
        model.addAttribute("tasks", taskService.findAll());
        return "index";
    }

    @RequestMapping(value = {"/createTask"}, method = RequestMethod.GET)
    public String viewCreateTask() {
        return "createTask";
    }

    @PostMapping("add")
    public String add(@RequestParam String summary, @RequestParam String assignee, @RequestParam Date startDate, @RequestParam Date endDate, Map<String, Object> model) {
        if (InputParamCheckerMessage.checkInputs(startDate, endDate, assignee, summary) != null) {
            model.put("message", InputParamCheckerMessage.checkInputs(startDate, endDate, assignee, summary));
            return "createTask";
        } else {
            taskService.save(new Task(summary, startDate, endDate, assignee));
            return "redirect:/index";
        }
    }

    @PostMapping("filter")
    public String filterDateAndAssignee(@RequestParam Date startDate, @RequestParam Date endDate, @RequestParam String period, @RequestParam String assignee, Map<String, Object> model) {
        model.put("messageNotFound", NotFoundMessageService.getNotFoundMessage(taskService.findAll()));
        model.put("messageSelectedFilter", MessageSelectedFilterService.getMessageSelectedFilter(assignee, startDate, endDate));
        model.put("uniqAssignee", UniqAssigneeService.getUniqAssignee(taskService.findAll()));
        model.put("tasks", taskService.findByFilter(assignee, startDate, endDate, period));
        return "index";
    }
}