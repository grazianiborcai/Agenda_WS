package br.com.mind5.payment.creditCard.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.model.action.LazyCrecardNodeCusparRefL1;
import br.com.mind5.payment.creditCard.model.action.LazyCrecardNodeDelete;
import br.com.mind5.payment.creditCard.model.action.LazyCrecardNodeUser;
import br.com.mind5.payment.creditCard.model.action.StdCrecardMergeToDelete;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckDelete;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckExist;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckUsername;

public final class RootCrecardDelete extends DeciTreeTemplateWrite<CrecardInfo> {
	
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
	
	
	
	@Override protected List<ActionStdV1<CrecardInfo>> buildActionsOnPassedHook(DeciTreeOption<CrecardInfo> option) {
		List<ActionStdV1<CrecardInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CrecardInfo> mergeToDelete = new StdCrecardMergeToDelete(option);
		ActionLazyV1<CrecardInfo> user = new LazyCrecardNodeUser(option.conn, option.schemaName);
		ActionLazyV1<CrecardInfo> cusparRef = new LazyCrecardNodeCusparRefL1(option.conn, option.schemaName);
		ActionLazyV1<CrecardInfo> delete = new LazyCrecardNodeDelete(option.conn, option.schemaName);
		
		mergeToDelete.addPostAction(user);
		user.addPostAction(cusparRef);		
		cusparRef.addPostAction(delete);
		
		actions.add(mergeToDelete);
		return actions;
	}
}
