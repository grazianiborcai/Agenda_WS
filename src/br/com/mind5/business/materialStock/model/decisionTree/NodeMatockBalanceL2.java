package br.com.mind5.business.materialStock.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.business.materialStock.model.action.StdMatockSuccess;
import br.com.mind5.business.materialStock.model.checker.MatockCheckBalance;
import br.com.mind5.business.materialStock.model.checker.MatockCheckLimit;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeMatockBalanceL2 extends DeciTreeTemplateWriteV2<MatockInfo> {
	
	public NodeMatockBalanceL2(DeciTreeOption<MatockInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatockInfo> buildCheckerHook(DeciTreeOption<MatockInfo> option) {
		List<ModelCheckerV1<MatockInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatockInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatockCheckBalance(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatockCheckLimit(checkerOption);
		queue.add(checker);

		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatockInfo>> buildActionsOnPassedHook(DeciTreeOption<MatockInfo> option) {
		List<ActionStdV1<MatockInfo>> actions = new ArrayList<>();

		ActionStdV1<MatockInfo> success = new StdMatockSuccess(option);
		
		actions.add(success);
		return actions;
	}
}
