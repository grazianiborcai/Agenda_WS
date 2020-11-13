package br.com.mind5.business.materialGroupStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialGroupStore.info.MatoporeInfo;
import br.com.mind5.business.materialGroupStore.model.action.StdMatoporeMergeMatore;
import br.com.mind5.business.materialGroupStore.model.checker.MatoporeCheckLangu;
import br.com.mind5.business.materialGroupStore.model.checker.MatoporeCheckOwner;
import br.com.mind5.business.materialGroupStore.model.checker.MatoporeCheckRead;
import br.com.mind5.business.materialGroupStore.model.checker.MatoporeCheckStore;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootMatoporeSelect extends DeciTreeTemplateRead<MatoporeInfo> {
	
	public RootMatoporeSelect(DeciTreeOption<MatoporeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatoporeInfo> buildCheckerHook(DeciTreeOption<MatoporeInfo> option) {
		ModelCheckerOption checkerOption;
		List<ModelChecker<MatoporeInfo>> queue = new ArrayList<>();		
		ModelChecker<MatoporeInfo> checker;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new MatoporeCheckRead(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatoporeCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatoporeCheckLangu(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatoporeCheckStore(checkerOption);
		queue.add(checker);	

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatoporeInfo>> buildActionsOnPassedHook(DeciTreeOption<MatoporeInfo> option) {
		List<ActionStd<MatoporeInfo>> actions = new ArrayList<>();
		
		ActionStd<MatoporeInfo> mergeMatore = new StdMatoporeMergeMatore(option);
		
		actions.add(mergeMatore);		
		return actions;
	}
}
