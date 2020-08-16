package br.com.mind5.business.materialStore.model.checker;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.action.LazyMatoreDaoSelect;
import br.com.mind5.business.materialStore.model.action.StdMatoreEnforceDel;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatoreCheckSoftDelete extends ModelCheckerTemplateActionV2<MatoreInfo, MatoreInfo> {
	
	public MatoreCheckSoftDelete(ModelCheckerOption option) {
		super(option, MatoreInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<MatoreInfo> buildActionHook(DeciTreeOption<MatoreInfo> option) {	
		ActionStdV1<MatoreInfo> enforceDel = new StdMatoreEnforceDel(option);
		ActionLazyV1<MatoreInfo> select = new LazyMatoreDaoSelect(option.conn, option.schemaName);
		
		enforceDel.addPostAction(select);
		
		return enforceDel;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.MAT_STORE_FLAGGED_AS_DELETED;
	}	
}
