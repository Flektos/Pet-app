package gr.hua.dit.petapp.services;

import gr.hua.dit.petapp.entities.MedicalHistory;
import gr.hua.dit.petapp.entities.Pet;
import gr.hua.dit.petapp.repositories.MedicalHistoryRepository;
import gr.hua.dit.petapp.repositories.PetRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalHistoryService
{
    private MedicalHistoryRepository medicalHistoryRepository;
    private PetRepository petRepository;

    public MedicalHistoryService(MedicalHistoryRepository medicalHistoryRepository, PetRepository petRepository)
    {
        this.medicalHistoryRepository = medicalHistoryRepository;
        this.petRepository = petRepository;
    }

    @Transactional
    public List<MedicalHistory> getMedicalHistories()
    {
        return medicalHistoryRepository.findAll();
    }

    @Transactional
    public MedicalHistory getMedicalHistory(Long id)
    {
        return medicalHistoryRepository.findById(id).get();
    }

    @Transactional
    public void saveMedicalHistory(MedicalHistory medicalHistory)
    {
        medicalHistoryRepository.save(medicalHistory);
    }

    @Transactional
    public void saveMedicalHistory(Long id, MedicalHistory medicalHistory)
    {
        Pet pet = petRepository.findById(id).get();
        medicalHistory.setPet(pet);
        medicalHistoryRepository.save(medicalHistory);

    }
}
