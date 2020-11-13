package br.com.mind5.payment.creditCard.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.model.action.LazyCrecardNodeAuth;
import br.com.mind5.payment.creditCard.model.action.LazyCrecardNodeDelete;
import br.com.mind5.payment.creditCard.model.action.StdCrecardMergeToDelete;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckDelete;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckExist;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckUsername;

public final class RootCrecardDelete extends DeciTreeTemplateWriteV2<CrecardInfo> {
	
	public RootCrecardDelete(DeciTreeOption<CrecardInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CrecardInfo> buildCheckerHook(DeciTreeOption<CrecardInfo> option) {
		List<ModelCheckerV1<CrecardInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CrecardInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CrecardCheckDelete(checkerOption);
		queue.add(checker);
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CrecardCheckExist(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CrecardCheckUsername(checkerOption);
		queue.add(checker);	

		return new ModelCheckerHelperQueueV2<CrecardInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<CrecardInfo>> buildActionsOnPassedHook(DeciTreeOption<CrecardInfo> option) {
		List<ActionStdV2<CrecardInfo>> actions = new ArrayList<>();
		
		ActionStdV2<CrecardInfo> mergeToDelete = new StdCrecardMergeToDelete(option);
		ActionLazy<CrecardInfo> nodeAuth = new LazyCrecardNodeAuth(option.conn, option.schemaName);
		ActionLazy<CrecardInfo> nodeDelete = new LazyCrecardNodeDelete(option.conn, option.schemaName);
		
		mergeToDelete.addPostAction(nodeAuth);
		nodeAuth.addPostAction(nodeDelete);
		
		actions.add(mergeToDelete);
		return actions;
	}
}
