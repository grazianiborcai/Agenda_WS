package br.com.mind5.business.materialText.model.checker;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.materialText.model.action.LazyMatextDaoSelect;
import br.com.mind5.business.materialText.model.action.StdMatextEnforceDel;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatextCheckSoftDelete extends ModelCheckerTemplateActionV2<MatextInfo, MatextInfo> {
	
	public MatextCheckSoftDelete(ModelCheckerOption option) {
		super(option, MatextInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<MatextInfo> buildActionHook(DeciTreeOption<MatextInfo> option) {
		ActionStdV1<MatextInfo> enforceDel = new StdMatextEnforceDel(option);
		ActionLazy<MatextInfo> select = new LazyMatextDaoSelect(option.conn, option.schemaName);
		
		enforceDel.addPostAction(select);
		
		return enforceDel;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.MAT_TEXT_FLAGGED_AS_DELETED;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_TEXT_NOT_FLAGGED_AS_DELETED;
	}
}
