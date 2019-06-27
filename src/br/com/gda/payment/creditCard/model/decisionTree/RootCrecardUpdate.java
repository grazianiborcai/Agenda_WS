package br.com.gda.payment.creditCard.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.payment.creditCard.info.CrecardInfo;
import br.com.gda.payment.creditCard.model.action.LazyCrecardMergeUsername;
import br.com.gda.payment.creditCard.model.action.LazyCrecardRootSelect;
import br.com.gda.payment.creditCard.model.action.LazyCrecardUpdate;
import br.com.gda.payment.creditCard.model.action.StdCrecardEnforceLChanged;
import br.com.gda.payment.creditCard.model.checker.CrecardCheckExist;
import br.com.gda.payment.creditCard.model.checker.CrecardCheckLangu;
import br.com.gda.payment.creditCard.model.checker.CrecardCheckOwner;
import br.com.gda.payment.creditCard.model.checker.CrecardCheckWrite;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootCrecardUpdate extends DeciTreeWriteTemplate<CrecardInfo> {
	
	public RootCrecardUpdate(DeciTreeOption<CrecardInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CrecardInfo> buildDecisionCheckerHook(DeciTreeOption<CrecardInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<CrecardInfo>> queue = new ArrayList<>();		
		ModelChecker<CrecardInfo> checker;
		ModelCheckerOption checkerOption;
		
		checker = new CrecardCheckWrite();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new CrecardCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new CrecardCheckLangu(checkerOption);
		queue.add(checker);
			
		new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new CrecardCheckExist(checkerOption);
		queue.add(checker);		

		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CrecardInfo>> buildActionsOnPassedHook(DeciTreeOption<CrecardInfo> option) {
		List<ActionStd<CrecardInfo>> actions = new ArrayList<>();

		ActionStd<CrecardInfo> enforceLChanged = new StdCrecardEnforceLChanged(option);	
		ActionLazy<CrecardInfo> enforceLChangedBy = new LazyCrecardMergeUsername(option.conn, option.schemaName);
		ActionLazy<CrecardInfo> updateMat = new LazyCrecardUpdate(option.conn, option.schemaName);	
		ActionLazy<CrecardInfo> select = new LazyCrecardRootSelect(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(updateMat);
		updateMat.addPostAction(select);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
