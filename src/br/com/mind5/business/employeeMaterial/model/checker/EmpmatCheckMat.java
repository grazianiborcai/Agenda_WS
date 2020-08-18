package br.com.mind5.business.employeeMaterial.model.checker;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.checker.MatCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class EmpmatCheckMat extends ModelCheckerTemplateForwardV2<EmpmatInfo, MatInfo> {
	
	public EmpmatCheckMat(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<MatInfo> getCheckerHook(ModelCheckerOption option) {
		return new MatCheckExist(option);
	}
	
	
	
	@Override protected MatInfo toForwardClass(EmpmatInfo baseRecord) {
		return MatInfo.copyFrom(baseRecord);
	}
}
