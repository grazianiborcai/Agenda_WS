package br.com.mind5.business.materialText.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.materialText.model.action.MatextVisiDaoUpdate;
import br.com.mind5.business.materialText.model.action.MatextVisiEnforceLChanged;
import br.com.mind5.business.materialText.model.action.MatextVisiEnforceTxtSearch;
import br.com.mind5.business.materialText.model.action.MatextVisiMergeToUpdate;
import br.com.mind5.business.materialText.model.action.MatextVisiMergeUsername;
import br.com.mind5.business.materialText.model.action.MatextVisiNodeDefaultL1;
import br.com.mind5.business.materialText.model.action.MatextVisiNodePostUpdate;
import br.com.mind5.business.materialText.model.action.MatextVisiRootSelect;
import br.com.mind5.business.materialText.model.checker.MatextCheckExist;
import br.com.mind5.business.materialText.model.checker.MatextCheckLangu;
import br.com.mind5.business.materialText.model.checker.MatextCheckLength;
import br.com.mind5.business.materialText.model.checker.MatextCheckMat;
import br.com.mind5.business.materialText.model.checker.MatextCheckOwner;
import br.com.mind5.business.materialText.model.checker.MatextCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class MatextRootUpdate extends DeciTreeTemplateWrite<MatextInfo> {
	
	public MatextRootUpdate(DeciTreeOption<MatextInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatextInfo> buildCheckerHook(DeciTreeOption<MatextInfo> option) {
		List<ModelChecker<MatextInfo>> queue = new ArrayList<>();		
		ModelChecker<MatextInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatextCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatextCheckLength(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MatextCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MatextCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MatextCheckMat(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MatextCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatextInfo>> buildActionsOnPassedHook(DeciTreeOption<MatextInfo> option) {
		List<ActionStd<MatextInfo>> actions = new ArrayList<>();

		ActionStd<MatextInfo> nodeSafe = new MatextNodeSafe(option).toAction();
		ActionStd<MatextInfo> mergeToUpdate = new ActionStdCommom<MatextInfo>(option, MatextVisiMergeToUpdate.class);
		ActionLazy<MatextInfo> nodeDefault = new ActionLazyCommom<MatextInfo>(option, MatextVisiNodeDefaultL1.class);
		ActionLazy<MatextInfo> enforceLChanged = new ActionLazyCommom<MatextInfo>(option, MatextVisiEnforceLChanged.class);	
		ActionLazy<MatextInfo> enforceLChangedBy = new ActionLazyCommom<MatextInfo>(option, MatextVisiMergeUsername.class);
		ActionLazy<MatextInfo> enforceTxtSearch = new ActionLazyCommom<MatextInfo>(option, MatextVisiEnforceTxtSearch.class);
		ActionLazy<MatextInfo> update = new ActionLazyCommom<MatextInfo>(option, MatextVisiDaoUpdate.class);
		ActionLazy<MatextInfo> postUpdate = new ActionLazyCommom<MatextInfo>(option, MatextVisiNodePostUpdate.class);
		ActionLazy<MatextInfo> select = new ActionLazyCommom<MatextInfo>(option, MatextVisiRootSelect.class);	
		
		mergeToUpdate.addPostAction(nodeDefault);
		nodeDefault.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceTxtSearch);
		enforceTxtSearch.addPostAction(update);
		update.addPostAction(postUpdate);
		postUpdate.addPostAction(select);
		
		actions.add(nodeSafe);
		actions.add(mergeToUpdate);
		
		return actions;
	}
}
