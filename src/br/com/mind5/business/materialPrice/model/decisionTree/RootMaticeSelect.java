package br.com.mind5.business.materialPrice.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialPrice.info.MaticeInfo;
import br.com.mind5.business.materialPrice.model.action.StdMaticeMergeMatore;
import br.com.mind5.business.materialPrice.model.checker.MaticeCheckLangu;
import br.com.mind5.business.materialPrice.model.checker.MaticeCheckRead;
import br.com.mind5.business.materialPrice.model.checker.MaticeCheckWeekday;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootMaticeSelect extends DeciTreeTemplateWrite<MaticeInfo> {
	
	public RootMaticeSelect(DeciTreeOption<MaticeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MaticeInfo> buildCheckerHook(DeciTreeOption<MaticeInfo> option) {
		List<ModelChecker<MaticeInfo>> queue = new ArrayList<>();		
		ModelChecker<MaticeInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MaticeCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MaticeCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MaticeCheckWeekday(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MaticeInfo>> buildActionsOnPassedHook(DeciTreeOption<MaticeInfo> option) {
		List<ActionStd<MaticeInfo>> actions = new ArrayList<>();
		
		ActionStd<MaticeInfo> mergeMatore = new StdMaticeMergeMatore(option);		
		
		actions.add(mergeMatore);
		return actions;
	}
}
