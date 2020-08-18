package br.com.mind5.business.employeeMaterial.model.checker;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.employeeMaterial.model.action.LazyEmpmatDaoSelect;
import br.com.mind5.business.employeeMaterial.model.action.StdEmpmatEnforceDel;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpmatCheckSoftDelete extends ModelCheckerTemplateActionV2<EmpmatInfo, EmpmatInfo> {	
	
	public EmpmatCheckSoftDelete(ModelCheckerOption option) {
		super(option, EmpmatInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<EmpmatInfo> buildActionHook(DeciTreeOption<EmpmatInfo> option) {		
		ActionStdV1<EmpmatInfo> enforceDel = new StdEmpmatEnforceDel(option);
		ActionLazyV1<EmpmatInfo> select = new LazyEmpmatDaoSelect(option.conn, option.schemaName);
		
		enforceDel.addPostAction(select);
		return enforceDel;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.EMP_MAT_FLAGGED_AS_DELETED;
	}	
}
