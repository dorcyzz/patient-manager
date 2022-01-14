package com.seb.patientmanager.service;

import com.seb.patientmanager.data.model.History;
import com.seb.patientmanager.data.repository.HistoryRepository;
import java.util.Optional;

public class HistoryService {
    private final HistoryRepository historyRepository;

    public HistoryService(HistoryRepository historyRepository) {
        super();

        this.historyRepository = historyRepository;
    }

    public History getHistory(Integer id) {
        Optional<History> history = this.historyRepository.findById(id);

        return history.orElse(null);
    }

    public History saveHistory(History history) {
        return this.historyRepository.save(history);
    }

    public void deleteHistory(Integer id) {
        History history = this.getHistory(id);

        if (history != null) {
            this.historyRepository.delete(history);
        }
    }
}
