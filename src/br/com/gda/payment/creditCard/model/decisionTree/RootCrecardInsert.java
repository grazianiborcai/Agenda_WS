package br.com.gda.payment.creditCard.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.payment.creditCard.info.CrecardInfo;
import br.com.gda.payment.creditCard.model.action.LazyCrecardNodeInsertL1;
import br.com.gda.payment.creditCard.model.action.LazyCrecardMergeAddress;
import br.com.gda.payment.creditCard.model.action.LazyCrecardMergePhone;
import br.com.gda.payment.creditCard.model.action.LazyCrecardMergeUsername;
import br.com.gda.payment.creditCard.model.action.LazyCrecardRootSelect;
import br.com.gda.payment.creditCard.model.action.StdCrecardEnforceLChanged;
import br.com.gda.payment.creditCard.model.checker.CrecardCheckAddress;
import br.com.gda.payment.creditCard.model.checker.CrecardCheckLangu;
import br.com.gda.payment.creditCard.model.checker.CrecardCheckOwner;
import br.com.gda.payment.creditCard.model.checker.CrecardCheckPhone;
import br.com.gda.payment.creditCard.model.checker.CrecardCheckUsername;
import br.com.gda.payment.creditCard.model.checker.CrecardCheckWrite;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootCrecardInsert extends DeciTreeWriteTemplate<CrecardInfo> {
	
	public RootCrecardInsert(DeciTreeOption<CrecardInfo> option) {
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
		checker = new CrecardCheckUsername(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new CrecardCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new CrecardCheckAddress(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new CrecardCheckPhone(checkerOption);
		queue.add(checker);

		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CrecardInfo>> buildActionsOnPassedHook(DeciTreeOption<CrecardInfo> option) {
		List<ActionStd<CrecardInfo>> actions = new ArrayList<>();		

		ActionStd<CrecardInfo> enforceLChanged = new StdCrecardEnforceLChanged(option);	
		ActionLazy<CrecardInfo> mergeUsername = new LazyCrecardMergeUsername(option.conn, option.schemaName);
		ActionLazy<CrecardInfo> mergeAddress = new LazyCrecardMergeAddress(option.conn, option.schemaName);
		ActionLazy<CrecardInfo> mergePhone = new LazyCrecardMergePhone(option.conn, option.schemaName);
		ActionLazy<CrecardInfo> nodeInsert = new LazyCrecardNodeInsertL1(option.conn, option.schemaName);
		ActionLazy<CrecardInfo> select = new LazyCrecardRootSelect(option.conn, option.schemaName);		
		
		enforceLChanged.addPostAction(mergeUsername);
		mergeUsername.addPostAction(mergeAddress);
		mergeAddress.addPostAction(mergePhone);
		mergePhone.addPostAction(nodeInsert);
		//nodeInsert.addPostAction(select);
		
		actions.add(enforceLChanged);		
		return actions;
	}
}
