package com.ZenPack.controllerTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.hamcrest.CoreMatchers;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ZenPack.Dto.FeatureDto;
import com.ZenPack.Dto.MenuDto;
import com.ZenPack.Dto.ZenPackDto;
import com.ZenPack.controller.ZenPackController;
import com.ZenPack.service.Impl.ZenPackServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
//@WebMvcTest(ZenPackController.class)
@AutoConfigureMockMvc
public class ZenPackControllerTest {
	
	@Autowired
	private  MockMvc mockMvc;
	
	@MockBean
	private ZenPackServiceImpl service;
	
	@InjectMocks
	private ZenPackController controller;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@BeforeClass
	public static void init(){
		
		ZenPackDto zenPackDto = new ZenPackDto();
		zenPackDto.setZenPackId(210L);
		zenPackDto.setName("Test_Controller");
		zenPackDto.setCreatedDate(new Date());
		zenPackDto.setCreatedBy("Team2");
		zenPackDto.setUpdatedBy("Team2");
		zenPackDto.setUpdatedTime(new Date());
		MenuDto menuDto = new MenuDto();
		menuDto.setMenuName("Test_zenpack1_menu");
		menuDto.setParentMenuId(101);
		menuDto.setCreatedTime(new Date());
		menuDto.setCreatedBy("Team2");
		
		FeatureDto featureDto = new FeatureDto();
		featureDto.setFeatureId("202");
		featureDto.setFeatureUrl("http://localhost:8091/api/v1/create");
		featureDto.setIcon("feature1");
		featureDto.setId(201);
		featureDto.setIsSettingMenu(true);
		featureDto.setParent(101);
		featureDto.setText("Menu Feature");
		
		List<FeatureDto> featureList = new ArrayList<FeatureDto>();
		featureList.add(featureDto);
		menuDto.setFeatures(featureList);
		
		List<MenuDto> menuList = new ArrayList<MenuDto>();
		menuList.add(menuDto);
		
		zenPackDto.setMenus(menuList);
		
		
	}
	
	@Test
	public void shouldCreateNewZenPack() throws JsonProcessingException, Exception {
		
		ZenPackDto zenPackDto = new ZenPackDto();
		zenPackDto.setZenPackId(210L);
		zenPackDto.setName("Test_Controller");
		zenPackDto.setCreatedDate(new Date());
		zenPackDto.setCreatedBy("Team2");
		zenPackDto.setUpdatedBy("Team2");
		zenPackDto.setUpdatedTime(new Date());
		MenuDto menuDto = new MenuDto();
		menuDto.setMenuName("Test_zenpack1_menu");
		menuDto.setParentMenuId(101);
		menuDto.setCreatedTime(new Date());
		menuDto.setCreatedBy("Team2");
		
		FeatureDto featureDto = new FeatureDto();
		featureDto.setFeatureId("202");
		featureDto.setFeatureUrl("http://localhost:8091/api/v1/create");
		featureDto.setIcon("feature1");
		featureDto.setId(201);
		featureDto.setIsSettingMenu(true);
		featureDto.setParent(101);
		featureDto.setText("Menu Feature");
		
		List<FeatureDto> featureList = new ArrayList<FeatureDto>();
		featureList.add(featureDto);
		menuDto.setFeatures(featureList);
		
		List<MenuDto> menuList = new ArrayList<MenuDto>();
		menuList.add(menuDto);
		
		zenPackDto.setMenus(menuList);
		
		String uri = "/api/v1/create";
		
//		 this.mockMvc.perform(post("/api/v1/create")
//                 .contentType(MediaType.APPLICATION_JSON)
//                 .content(objectMapper.writeValueAsString(zenPackDto)))
//         .andExpect(status().isOk());
		 
		String dto = objectMapper.writeValueAsString(zenPackDto);
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(dto)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertThat(200).isEqualTo(status);
		
		
		
		
	}

}
