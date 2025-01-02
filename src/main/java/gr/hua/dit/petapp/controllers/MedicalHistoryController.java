package gr.hua.dit.petapp.controllers;

import gr.hua.dit.petapp.entities.MedicalHistory;
import gr.hua.dit.petapp.services.MedicalHistoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class MedicalHistoryController
{
    private final MedicalHistoryService medicalHistoryService;

    public MedicalHistoryController(MedicalHistoryService medicalHistoryService)
    {
        this.medicalHistoryService = medicalHistoryService;
    }

    @GetMapping
    public List<MedicalHistory> showMedicalHistories()
    {
        List<MedicalHistory> medicalHistoryList = medicalHistoryService.getMedicalHistories();
        return medicalHistoryList;
    }

    @GetMapping("/{id}")
    public MedicalHistory showMedicalHistory(@PathVariable Long id)
    {
        MedicalHistory medicalHistory = medicalHistoryService.getMedicalHistory(id);
        return medicalHistory;
    }

    @PostMapping("/{id}")
    public void addMedicalHistory(@PathVariable Long id, @RequestBody MedicalHistory medicalHistory)
    {
        medicalHistoryService.saveMedicalHistory(id, medicalHistory);
    }
}
