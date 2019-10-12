package com.meze.atmapi.wrapper;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.meze.atmapi.dto.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CajeroAutomaticoList {
	
	private List<CajeroAutomatico> cajerosAutomaticos;

	public List<CajeroAutomatico> getCajerosAutomaticos() {
		return cajerosAutomaticos;
	}

	public void setCajerosAutomaticos(List<CajeroAutomatico> cajerosAutomaticos) {
		this.cajerosAutomaticos = cajerosAutomaticos;
	}

	public CajeroAutomaticoList() {
		cajerosAutomaticos = new ArrayList<>();
	}

//	public CajeroAutomaticoList(List<CajeroAutomatico> cajerosAutomaticos) {
//		super();
//		this.cajerosAutomaticos = cajerosAutomaticos;
//	}

}
