package br.com.gda.business.person.model.action;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.model.action.commom.ActionVisitorTemplateFilter;

final class VisiPersonFilterCpfNull extends ActionVisitorTemplateFilter<PersonInfo> {
	
	@Override protected boolean filterOutHook(PersonInfo recordInfo) {
		if (recordInfo.cpf == null)
			return super.KEEP_RECORD;
		
		return super.SKIP_RECORD;
	}
}
