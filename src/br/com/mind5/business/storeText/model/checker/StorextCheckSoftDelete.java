package br.com.mind5.business.storeText.model.checker;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeText.model.action.LazyStorextDaoSelect;
import br.com.mind5.business.storeText.model.action.StdStorextEnforceDel;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorextCheckSoftDelete extends ModelCheckerTemplateAction<StorextInfo, StorextInfo> {
	
	public StorextCheckSoftDelete(ModelCheckerOption option) {
		super(option, StorextInfo.class);
	}
	
	
	
	@Override protected ActionStd<StorextInfo> buildActionHook(DeciTreeOption<StorextInfo> option) {
		ActionStd<StorextInfo> enforceDel = new StdStorextEnforceDel(option);
		ActionLazy<StorextInfo> select = new LazyStorextDaoSelect(option.conn, option.schemaName);
		
		enforceDel.addPostAction(select);
		
		return enforceDel;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STORE_TEXT_FLAGGED_AS_DELETED;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_TEXT_NOT_FLAGGED_AS_DELETED;
	}
}
