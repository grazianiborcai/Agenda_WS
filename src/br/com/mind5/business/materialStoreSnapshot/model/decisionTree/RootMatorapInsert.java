package br.com.mind5.business.materialStoreSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStoreSnapshot.info.MatorapInfo;
import br.com.mind5.business.materialStoreSnapshot.model.action.StdMatorapDaoInsert;
import br.com.mind5.business.materialStoreSnapshot.model.checker.MatorapCheckInsert;
import br.com.mind5.business.materialStoreSnapshot.model.checker.MatorapCheckLangu;
import br.com.mind5.business.materialStoreSnapshot.model.checker.MatorapCheckMatore;
import br.com.mind5.business.materialStoreSnapshot.model.checker.MatorapCheckOwner;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootMatorapInsert extends DeciTreeTemplateWrite<MatorapInfo> {
	
	public RootMatorapInsert(DeciTreeOption<MatorapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatorapInfo> buildCheckerHook(DeciTreeOption<MatorapInfo> option) {
		List<ModelChecker<MatorapInfo>> queue = new ArrayList<>();		
		ModelChecker<MatorapInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new MatorapCheckInsert(checkerOption);
		queue.add(checker);			
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatorapCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatorapCheckLangu(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatorapCheckMatore(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatorapInfo>> buildActionsOnPassedHook(DeciTreeOption<MatorapInfo> option) {
		List<ActionStd<MatorapInfo>> actions = new ArrayList<>();
		
		ActionStd<MatorapInfo> insert = new StdMatorapDaoInsert(option);
		
		actions.add(insert);	
		return actions;
	}
}
