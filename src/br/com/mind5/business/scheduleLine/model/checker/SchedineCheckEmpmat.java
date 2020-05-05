package br.com.mind5.business.scheduleLine.model.checker;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.employeeMaterial.model.checker.EmpmatCheckExist;
import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class SchedineCheckEmpmat extends ModelCheckerTemplateForwardV2<SchedineInfo, EmpmatInfo> {
	
	public SchedineCheckEmpmat(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<EmpmatInfo> getCheckerHook(ModelCheckerOption option) {
		return new EmpmatCheckExist(option);
	}
	
	
	
	@Override protected EmpmatInfo toForwardClass(SchedineInfo baseRecord) {
		return EmpmatInfo.copyFrom(baseRecord);
	}
}
