package br.com.mind5.business.material.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.action.StdMatSuccess;
import br.com.mind5.business.material.model.checker.MatCheckProductPriceUnit;
import br.com.mind5.business.material.model.checker.MatCheckProductUnit;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV1;

public final class NodeMatProductL2 extends DeciTreeTemplateWriteV1<MatInfo> {
	
	public NodeMatProductL2(DeciTreeOption<MatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatInfo> buildCheckerHook(DeciTreeOption<MatInfo> option) {
		List<ModelCheckerV1<MatInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;			
		checker = new MatCheckProductUnit(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;			
		checker = new MatCheckProductPriceUnit(checkerOption);
		queue.add(checker);		

		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatInfo>> buildActionsOnPassedHook(DeciTreeOption<MatInfo> option) {
		List<ActionStdV1<MatInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<MatInfo> success = new StdMatSuccess(option);	
		
		actions.add(success);		
		return actions;
	}
}
