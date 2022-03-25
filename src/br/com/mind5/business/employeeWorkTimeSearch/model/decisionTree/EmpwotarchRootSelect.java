package br.com.mind5.business.employeeWorkTimeSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeSearch.info.EmpwotarchInfo;
import br.com.mind5.business.employeeWorkTimeSearch.model.action.EmpwotarchVisiMergeToSelect;
import br.com.mind5.business.employeeWorkTimeSearch.model.checker.EmpwotarchCheckLangu;
import br.com.mind5.business.employeeWorkTimeSearch.model.checker.EmpwotarchCheckOwner;
import br.com.mind5.business.employeeWorkTimeSearch.model.checker.EmpwotarchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class EmpwotarchRootSelect extends DeciTreeTemplateRead<EmpwotarchInfo> {
	
	public EmpwotarchRootSelect(DeciTreeOption<EmpwotarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpwotarchInfo> buildCheckerHook(DeciTreeOption<EmpwotarchInfo> option) {
		List<ModelChecker<EmpwotarchInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpwotarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmpwotarchCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpwotarchCheckLangu(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpwotarchCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpwotarchInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpwotarchInfo> option) {
		List<ActionStd<EmpwotarchInfo>> actions = new ArrayList<>();
		
		ActionStd<EmpwotarchInfo> select = new ActionStdCommom<EmpwotarchInfo>(option, EmpwotarchVisiMergeToSelect.class);

		actions.add(select);
		return actions;
	}
}
