package br.com.mind5.business.employeeMaterial.model.checker;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.employeeMaterial.model.action.LazyEmpmatDaoSelect;
import br.com.mind5.business.employeeMaterial.model.action.StdEmpmatEnforceDel;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpmatCheckSoftDelete extends ModelCheckerTemplateActionV2<EmpmatInfo, EmpmatInfo> {	
	
	public EmpmatCheckSoftDelete(ModelCheckerOption option) {
		super(option, EmpmatInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<EmpmatInfo> buildActionHook(DeciTreeOption<EmpmatInfo> option) {		
		ActionStdV2<EmpmatInfo> enforceDel = new StdEmpmatEnforceDel(option);
		ActionLazy<EmpmatInfo> select = new LazyEmpmatDaoSelect(option.conn, option.schemaName);
		
		enforceDel.addPostAction(select);
		return enforceDel;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.EMP_MAT_FLAGGED_AS_DELETED;
	}	
}
