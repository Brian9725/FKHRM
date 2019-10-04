/**
 * @Author: BrianHu
 * @Date: 2019/10/4
 * @Time: 9:36
 */
package pers.brian.hrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormController {
    @RequestMapping(value = "/{formName}")
    public String formName(@PathVariable String formName){
        return formName;
    }
}
