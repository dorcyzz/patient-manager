package com.seb.patientmanager.rest.controller;

import com.seb.patientmanager.data.model.History;
import com.seb.patientmanager.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/history")
@CrossOrigin
public class HistoryRestController {
    private final HistoryService historyService;

    public HistoryRestController(@Autowired HistoryService historyService) {
        super();

        this.historyService = historyService;
    }

    @GetMapping
    public History getHistory(@RequestParam Integer id) {
        return this.historyService.getHistory(id);
    }

    @PostMapping
    public History createHistory(@RequestBody History history) {
        return this.historyService.saveHistory(history);
    }

    @PutMapping
    public History updateHistory(@RequestBody History history) {
        return this.historyService.saveHistory(history);
    }

    @DeleteMapping
    public void deleteHistory(@RequestParam Integer id) {
        this.historyService.deleteHistory(id);
    }
}
