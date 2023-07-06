package com.example.LMS.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LMS.dto.LMSDTO;
import com.example.LMS.entity.LMS;
import com.example.LMS.exception.ResourceNotFoundException;
import com.example.LMS.repo.LMSDAO;
import com.example.LMS.service.LMSService;

@Service
public class LMSServiceImpl implements LMSService {
    private final LMSDAO lmsDAO;
    
    @Autowired
    public LMSServiceImpl(LMSDAO lmsDAO) {
        this.lmsDAO = lmsDAO;
    }
    
    @Override
    public LMSDTO createLMS(LMSDTO lmsDTO) {
        LMS lms = new LMS();
        BeanUtils.copyProperties(lmsDTO, lms);
        lms = lmsDAO.save(lms);
        BeanUtils.copyProperties(lms, lmsDTO);
        return lmsDTO;
    }
    
    @Override
    public LMSDTO getLMSById(Long id) {
        LMS lms = lmsDAO.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("LMS not found with id: " + id));
        LMSDTO lmsDTO = new LMSDTO();
        BeanUtils.copyProperties(lms, lmsDTO);
        return lmsDTO;
    }
    
    @Override
    public List<LMSDTO> getAllLMS() {
        return lmsDAO.findAll().stream()
                .map(lms -> {
                    LMSDTO lmsDTO = new LMSDTO();
                    BeanUtils.copyProperties(lms, lmsDTO);
                    return lmsDTO;
                })
                .collect(Collectors.toList());
    }
    
    @Override
    public List<LMSDTO> searchLMSByTitle(String title) {
        return lmsDAO.findByTitleContainingIgnoreCase(title).stream()
                .map(lms -> {
                    LMSDTO lmsDTO = new LMSDTO();
                    BeanUtils.copyProperties(lms, lmsDTO);
                    return lmsDTO;
                })
                .collect(Collectors.toList());
    }
    
    @Override
    public LMSDTO updateLMS(Long id, LMSDTO lmsDTO) {
        LMS lms = lmsDAO.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("LMS not found with id: " + id));
        BeanUtils.copyProperties(lmsDTO, lms);
        lms = lmsDAO.save(lms);
        BeanUtils.copyProperties(lms, lmsDTO);
        return lmsDTO;
    }
    
    @Override
    public boolean deleteLMS(Long id) {
        LMS lms = lmsDAO.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("LMS not found with id: " + id));
        lmsDAO.delete(lms);
        return true; // Return true if deletion is successful
    }


}


