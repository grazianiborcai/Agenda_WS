package br.com.mind5.business.company.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.entityCategory.info.Entiteg;

public final class CompSetterCategStore extends InfoSetterTemplate<CompInfo> {
	
	@Override protected CompInfo setAttrHook(CompInfo recordInfo) {
		recordInfo.codEntityCateg = Entiteg.STORE.getCodEntityCateg();
		return recordInfo;
	}
}
