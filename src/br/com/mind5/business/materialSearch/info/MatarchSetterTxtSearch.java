package br.com.mind5.business.materialSearch.info;

import java.text.Normalizer;

import br.com.mind5.info.InfoSetterTemplate;

public final class MatarchSetterTxtSearch extends InfoSetterTemplate<MatarchInfo> {
	
	@Override protected MatarchInfo setAttrHook(MatarchInfo recordInfo) {
		if (recordInfo.txtMat == null)
			return recordInfo;		
		
		recordInfo.txtMatSearch = recordInfo.txtMat.toUpperCase();
		recordInfo.txtMatSearch = Normalizer.normalize(recordInfo.txtMatSearch, Normalizer.Form.NFD);
		recordInfo.txtMatSearch = recordInfo.txtMatSearch.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
		
		return recordInfo;
	}
}
