package br.com.mind5.business.materialText.info;

import br.com.mind5.common.StringUtil;
import br.com.mind5.info.InfoSetterTemplate;

public final class MatextSetterTxtSearch extends InfoSetterTemplate<MatextInfo> {
	
	@Override protected MatextInfo setAttrHook(MatextInfo recordInfo) {	
		recordInfo.txtMatSearch = StringUtil.normalizeSearch(recordInfo.txtMat);		
		return recordInfo;
	}
}
