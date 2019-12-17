package com.job.register.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.job.register.dao.CandidateRepository;
import com.job.register.dao.ExamRepository;
import com.job.register.dto.response.CandidateResponse;
import com.job.register.dto.response.ExamResponse;
import com.job.register.entities.Candidate;
import com.job.register.entities.Exam;
import com.job.register.exception.CandidateNotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class CandidateServiceImplTest {
	@Mock
	CandidateRepository candidateRepository;

	@Mock
	ExamRepository examRepository;

	@InjectMocks
	private CandidateServiceImpl service;

	public Candidate getCandidateRequest() {

		Candidate request = new Candidate();
		Exam e = new Exam();
		e.setPosition("Java Developer");
		e.setDate("16-dec-2019");
		e.setId(100);

		Exam e1 = new Exam();
		e1.setPosition("UI Developer");
		e1.setDate("20-dec-2019");
		e1.setId(101);

		List<Exam> listExam = new ArrayList<>();
		listExam.add(e);
		listExam.add(e1);
		request.setId(1001);
		request.setName("Rahul");
		request.setQualification("BE");
		request.setExperience("4");
		request.setExams(listExam);

		return request;

	}

	/*
	 * @Test public void saveCandidate() throws ExamNotFoundException,
	 * CandidateAlreadyExistException { Candidate candidate = getCandidateRequest();
	 * 
	 * 
	 * ExamRequest eRequest=new ExamRequest();; CandidateResponse cResponse=new
	 * CandidateResponse(); ExamResponse eResponse= new ExamResponse();
	 * 
	 * 
	 * CandidateRequest cRequest=new CandidateRequest();
	 * 
	 * cRequest.setName(candidate.getName());
	 * cRequest.setExperience(candidate.getExperience());
	 * cRequest.setQualification(candidate.getQualification());
	 * cRequest.setSkills(candidate.getSkills());
	 * 
	 * List<String> list=new ArrayList<>(); list.add("Java Test");
	 * list.add("UI Test");
	 * 
	 * 
	 * cRequest.setExams((ArrayList<String>) list);
	 * 
	 * cResponse.setId(candidate.getId());
	 * cResponse.setExperience(candidate.getExperience());
	 * cResponse.setName(candidate.getName());
	 * cResponse.setSkills(candidate.getSkills());
	 * cResponse.setQualification(candidate.getQualification());
	 * 
	 * List<Exam> getlist= candidate.getExams(); List<Exam> elist=new ArrayList<>();
	 * for (Exam info : getlist) { Exam e=new Exam();
	 * 
	 * e.setId(info.getId()); e.setPosition(info.getPosition());
	 * e.setDate(info.getDate()); elist.add(e); }
	 * 
	 * cResponse.setExams(elist);
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * when(candidateRepository.save(candidate)).thenReturn(candidate); Exam res=new
	 * Exam(); res.setId(10); res.setPosition("Java developer");
	 * res.setDate("13-dec-2019"); Mockito.when( examRepository.findByPosition(
	 * Mockito.anyString() ) ).thenReturn(res ); CandidateResponse result =
	 * service.addCandidate(cRequest); assertEquals(result.getName(),
	 * cResponse.getName());
	 * 
	 * 
	 * }
	 */
	@Test
	public void findByCandidateId() throws CandidateNotFoundException {
		Candidate candidate = getCandidateRequest();
		CandidateResponse cResponse = new CandidateResponse();
		cResponse.setId(candidate.getId());
		cResponse.setExperience(candidate.getExperience());
		cResponse.setName(candidate.getName());
		cResponse.setSkills(candidate.getSkills());
		cResponse.setQualification(candidate.getQualification());

		ExamResponse eResponse = new ExamResponse();

		List<Exam> getlist = candidate.getExams();
		List<Exam> elist = new ArrayList<>();
		for (Exam info : getlist) {
			Exam e = new Exam();
			eResponse.setId(e.getId());
			eResponse.setPosition(e.getPosition());
			eResponse.setDate(e.getDate());
			elist.add(e);
		}

		cResponse.setExams(elist);

		when(candidateRepository.findById(1001)).thenReturn(Optional.of(candidate));
		CandidateResponse result = service.getCandidate(1001);
		assertEquals(result.getId(), candidate.getId());

	}

}
