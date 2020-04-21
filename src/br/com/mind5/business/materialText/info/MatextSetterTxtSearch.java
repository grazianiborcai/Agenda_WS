package br.com.mind5.business.materialText.info;

import java.text.Normalizer;

import br.com.mind5.info.InfoSetterTemplate;

public final class MatextSetterTxtSearch extends InfoSetterTemplate<MatextInfo> {
	
	@Override protected MatextInfo setAttrHook(MatextInfo recordInfo) {	
		if (recordInfo.txtMat == null)
			return recordInfo;
		
		
		recordInfo.txtMatSearch = recordInfo.txtMat.toUpperCase();
		recordInfo.txtMatSearch = Normalizer.normalize(recordInfo.txtMatSearch, Normalizer.Form.NFD);
		recordInfo.txtMatSearch = recordInfo.txtMatSearch.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
		
		return recordInfo;
	}
}
