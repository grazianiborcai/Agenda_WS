package br.com.gda.business.schedule.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.schedule.info.ScheduInfo;
import br.com.gda.business.schedule.model.action.LazyOrderemMergeMat;
import br.com.gda.business.schedule.model.action.LazyOrderemNodeInsert;
import br.com.gda.business.schedule.model.action.LazyScheduEnforceLChanged;
import br.com.gda.business.schedule.model.action.StdScheduEnforceLChanged;
import br.com.gda.business.schedule.model.checker.ScheduCheckCus;
import br.com.gda.business.schedule.model.checker.ScheduCheckLangu;
import br.com.gda.business.schedule.model.checker.ScheduCheckMat;
import br.com.gda.business.schedule.model.checker.ScheduCheckOwner;
import br.com.gda.business.schedule.model.checker.ScheduCheckStore;
import br.com.gda.business.schedule.model.checker.ScheduCheckWrite;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootOrderemInsert extends DeciTreeWriteTemplate<ScheduInfo> {
	
	public RootOrderemInsert(DeciTreeOption<ScheduInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<ScheduInfo> buildDecisionCheckerHook(DeciTreeOption<ScheduInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<ScheduInfo>> queue = new ArrayList<>();		
		ModelChecker<ScheduInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new ScheduCheckWrite();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new ScheduCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new ScheduCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new ScheduCheckMat(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new ScheduCheckStore(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new ScheduCheckCus(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<ScheduInfo>> buildActionsOnPassedHook(DeciTreeOption<ScheduInfo> option) {
		List<ActionStd<ScheduInfo>> actions = new ArrayList<>();
		
		ActionStd<ScheduInfo> nodeOrder = new NodeScheduOrderL1(option).toAction();
		ActionLazy<ScheduInfo> enforceLChanged = new LazyScheduEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<ScheduInfo> mergeMat = new LazyOrderemMergeMat(option.conn, option.schemaName);
		ActionLazy<ScheduInfo> nodeInsert = new LazyOrderemNodeInsert(option.conn, option.schemaName);
		
		nodeOrder.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(mergeMat);
		mergeMat.addPostAction(nodeInsert);
		
		actions.add(nodeOrde);
		return actions;
	}
}
