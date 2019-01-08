package br.com.gda.business.company.model.action;

import br.com.gda.business.company.info.CompInfo;
import br.com.gda.model.action.commom.ActionVisitorTemplateFilter;

final class VisiCompFilterCnpjNull extends ActionVisitorTemplateFilter<CompInfo> {
	
	@Override protected boolean filterOutHook(CompInfo recordInfo) {
		if (recordInfo.cnpj == null)
			return super.KEEP_RECORD;
		
		return super.SKIP_RECORD;
	}
}
