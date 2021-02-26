package io.github.pheonixvx.aiimprovementsfabric.modifier;

import io.github.pheonixvx.aiimprovementsfabric.modifier.editor.ModifierLayer;
import io.github.pheonixvx.aiimprovementsfabric.modifier.filters.FilterLayer;
import io.github.pheonixvx.aiimprovementsfabric.modifier.filters.FilterNode;
import io.github.pheonixvx.aiimprovementsfabric.modifier.filters.FilterResult;
import io.github.pheonixvx.aiimprovementsfabric.modifier.filters.IFilterNode;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.MobEntity;

import java.util.function.Function;

/**
 * Created by Dark(DarkGuardsman, Robert) on 8/3/2019. Ported to Fabric by PheonixVX on 2/24/2021.
 */
public class ModifierLevel extends FilterNode {
	public final ModifierLayer goalEditor = new ModifierLayer(false);
	public final ModifierLayer combatGoalEditor = new ModifierLayer(true);
	public final FilterLayer filters = new FilterLayer(null);

	public static ModifierLevel newFilter(Function<Entity, Boolean> filter)
	{
		return new ModifierLevel(((entity) -> filter.apply(entity) ? FilterResult.FILTERED : FilterResult.DID_NOTHING));
	}

	private ModifierLevel(IFilterNode filter)
	{
		super(filter);
	}

	@Override
	public FilterResult handle(Entity entity)
	{
		FilterResult filterResult = action.handle(entity);
		if (filterResult != FilterResult.DID_NOTHING)
		{
			if (entity instanceof MobEntity)
			{
				goalEditor.handle((MobEntity) entity);
				combatGoalEditor.handle((MobEntity) entity);
			}
			return filters.handle(entity);
		}
		return filterResult;
	}
}
