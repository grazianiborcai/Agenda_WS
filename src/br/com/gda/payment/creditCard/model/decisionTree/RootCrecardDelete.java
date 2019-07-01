package br.com.gda.payment.creditCard.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.payment.creditCard.info.CrecardInfo;
import br.com.gda.payment.creditCard.model.action.LazyCrecardEnforceLChanged;
import br.com.gda.payment.creditCard.model.action.LazyCrecardMergeCuspar;
import br.com.gda.payment.creditCard.model.action.LazyCrecardMergeUsername;
import br.com.gda.payment.creditCard.model.action.LazyCrecardNodeDelete;
import br.com.gda.payment.creditCard.model.action.StdCrecardMergeToDelete;
import br.com.gda.payment.creditCard.model.checker.CrecardCheckDelete;
import br.com.gda.payment.creditCard.model.checker.CrecardCheckExist;
import br.com.gda.payment.creditCard.model.checker.CrecardCheckUsername;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootCrecardDelete extends DeciTreeWriteTemplate<CrecardInfo> {
	
	public RootCrecardDelete(DeciTreeOption<CrecardInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CrecardInfo> buildDecisionCheckerHook(DeciTreeOption<CrecardInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<CrecardInfo>> queue = new ArrayList<>();		
		ModelChecker<CrecardInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checker = new CrecardCheckDelete();
		queue.add(checker);
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new CrecardCheckExist(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
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
