package br.com.mind5.payment.creditCard.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.model.action.LazyCrecardEnforceLChanged;
import br.com.mind5.payment.creditCard.model.action.LazyCrecardMergeCuspar;
import br.com.mind5.payment.creditCard.model.action.LazyCrecardMergeUsername;
import br.com.mind5.payment.creditCard.model.action.LazyCrecardNodeDelete;
import br.com.mind5.payment.creditCard.model.action.StdCrecardMergeToDelete;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckDelete;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckExist;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckUsername;

public final class RootCrecardDelete extends DeciTreeWriteTemplate<CrecardInfo> {
	
	public RootCrecardDelete(DeciTreeOption<CrecardInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CrecardInfo> buildDecisionCheckerHook(DeciTreeOption<CrecardInfo> option) {
		List<ModelChecker<CrecardInfo>> queue = new ArrayList<>();		
		ModelChecker<CrecardInfo> checker;
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

		return new ModelCheckerQueue<CrecardInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CrecardInfo>> buildActionsOnPassedHook(DeciTreeOption<CrecardInfo> option) {
		List<ActionStd<CrecardInfo>> actions = new ArrayList<>();
		
		ActionStd<CrecardInfo> mergeToDelete = new StdCrecardMergeToDelete(option);
		ActionLazy<CrecardInfo> enforceLChanged = new LazyCrecardEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<CrecardInfo> enforceLChangedBy = new LazyCrecardMergeUsername(option.conn, option.schemaName);
		ActionLazy<CrecardInfo> mergeCuspar = new LazyCrecardMergeCuspar(option.conn, option.schemaName);
		ActionLazy<CrecardInfo> delete = new LazyCrecardNodeDelete(option.conn, option.schemaName);
		
		mergeToDelete.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(mergeCuspar);		
		mergeCuspar.addPostAction(delete);
		
		actions.add(mergeToDelete);
		return actions;
	}
}
