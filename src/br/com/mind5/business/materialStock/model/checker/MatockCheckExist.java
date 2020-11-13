package br.com.mind5.business.materialStock.model.checker;

import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.business.materialStock.model.action.StdMatockDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatockCheckExist extends ModelCheckerTemplateActionV2<MatockInfo, MatockInfo> {
	
	public MatockCheckExist(ModelCheckerOption option) {
		super(option, MatockInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<MatockInfo> buildActionHook(DeciTreeOption<MatockInfo> option) {		
		ActionStdV2<MatockInfo> select = new StdMatockDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.MAT_STOCK_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_STOCK_NOT_FOUND;
	}
}
