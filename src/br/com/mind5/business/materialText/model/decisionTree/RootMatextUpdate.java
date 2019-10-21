package br.com.mind5.business.materialText.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.materialText.model.action.LazyMatextMergeUsername;
import br.com.mind5.business.materialText.model.action.LazyMatextNodeHasDefault;
import br.com.mind5.business.materialText.model.action.LazyMatextUpdate;
import br.com.mind5.business.materialText.model.action.StdMatextEnforceLChanged;
import br.com.mind5.business.materialText.model.checker.MatextCheckExist;
import br.com.mind5.business.materialText.model.checker.MatextCheckLangu;
import br.com.mind5.business.materialText.model.checker.MatextCheckMat;
import br.com.mind5.business.materialText.model.checker.MatextCheckOwner;
import br.com.mind5.business.materialText.model.checker.MatextCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootMatextUpdate extends DeciTreeWriteTemplate<MatextInfo> {
	
	public RootMatextUpdate(DeciTreeOption<MatextInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatextInfo> buildDecisionCheckerHook(DeciTreeOption<MatextInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<MatextInfo>> queue = new ArrayList<>();		
		ModelChecker<MatextInfo> checker;
		ModelCheckerOption checkerOption;
		
		checker = new MatextCheckWrite();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new MatextCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new MatextCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new MatextCheckMat(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new MatextCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatextInfo>> buildActionsOnPassedHook(DeciTreeOption<MatextInfo> option) {
		List<ActionStd<MatextInfo>> actions = new ArrayList<>();

		ActionStd<MatextInfo> nodeDefaultOn = new NodeMatextDefaultOn(option).toAction();
		ActionStd<MatextInfo> enforceLChanged = new StdMatextEnforceLChanged(option);	
		ActionLazy<MatextInfo> enforceLChangedBy = new LazyMatextMergeUsername(option.conn, option.schemaName);
		ActionLazy<MatextInfo> update = new LazyMatextUpdate(option.conn, option.schemaName);
		ActionLazy<MatextInfo> nodeHasDefault = new LazyMatextNodeHasDefault(option.conn, option.schemaName);
		ActionStd<MatextInfo> select = new RootMatextSelect(option).toAction();	
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		update.addPostAction(nodeHasDefault);
		
		actions.add(nodeDefaultOn);
		actions.add(enforceLChanged);
		actions.add(select);
		return actions;
	}
}
