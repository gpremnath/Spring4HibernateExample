package com.office.spring.mvc.controller;

/**
 * Created by premnath on 17/4/16.
 */
import com.office.spring.model.Group;
import com.office.spring.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by premnath on 29/11/15.
 */

@Controller
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupService groupService;
    /*
    * This method will provide the medium to add a new group.
    */
    @RequestMapping(value = { "new" }, method = RequestMethod.GET)
    public String newGroup(ModelMap model) {
        Group group = new Group();
        model.addAttribute("group", group);
        model.addAttribute("edit", false);
        return "addgroup";
    }

    @RequestMapping(value = { "new" }, method = RequestMethod.POST)
    public String saveGroup(Group group,BindingResult bindingResult, ModelMap model) {
        groupService.saveGroup(group);
        return "addgroup";
    }

    @RequestMapping(value = {  "list" }, method = RequestMethod.GET)
    public String listGroups(ModelMap model) {
        List<Group> groups = groupService.listAllGroups();
        model.addAttribute("groups", groups);
        return "allgroups";
    }

    @RequestMapping(value = { "edit-{id}-group" }, method = RequestMethod.GET)
    public String editEmployee(@PathVariable Long id, ModelMap model) {
        Group group = groupService.findById(id);
        model.addAttribute("group", group);
        model.addAttribute("edit", true);
        return "addgroup";
    }
}
