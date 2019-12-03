package br.com.mind5.business.materialText.model.checker;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.materialText.model.action.LazyMatextSelect;
import br.com.mind5.business.materialText.model.action.StdMatextEnforceDel;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatextCheckSoftDelete extends ModelCheckerTemplateActionV2<MatextInfo, MatextInfo> {
	
	public MatextCheckSoftDelete(ModelCheckerOption option) {
		super(option, MatextInfo.class);
	}
	
	
	
	@Override protected ActionStd<MatextInfo> buildActionHook(DeciTreeOption<MatextInfo> option) {
		ActionStd<MatextInfo> enforceDel = new StdMatextEnforceDel(option);
		ActionLazy<MatextInfo> select = new LazyMatextSelect(option.conn, option.schemaName);
		
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
