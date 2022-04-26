package br.com.mind5.business.employeeLunchTime.model.checker;

import br.com.mind5.business.employeeLunchTime.info.EmplutmInfo;
import br.com.mind5.business.employeeLunchTimeSearch.info.EmplutmarchInfo;
import br.com.mind5.business.employeeLunchTimeSearch.model.checker.EmplutmarchCheckExistEmpos;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class EmplutmCheckEmplutmarchEmpos extends ModelCheckerTemplateForward<EmplutmInfo, EmplutmarchInfo> {
	
	public EmplutmCheckEmplutmarchEmpos(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<EmplutmarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new EmplutmarchCheckExistEmpos(option);
	}
	
	
	
	@Override protected EmplutmarchInfo toForwardClass(EmplutmInfo baseRecord) {
		return EmplutmarchInfo.copyFrom(baseRecord);
	}
}
