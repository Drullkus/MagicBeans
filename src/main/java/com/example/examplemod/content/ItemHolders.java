package com.example.examplemod.content;

import com.example.examplemod.ExampleMod;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import tamaized.beanification.Component;

import java.util.Objects;

@Component
public class ItemHolders {
	public final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ExampleMod.MODID);

	public final DeferredItem<Item> EXAMPLE_ITEM = ITEMS.registerSimpleItem("example_item", new Item.Properties().food(new FoodProperties.Builder()
			.alwaysEdible().nutrition(1).saturationModifier(2f).build()));

	{
		IEventBus modBus = Objects.requireNonNull(ModLoadingContext.get().getActiveContainer().getEventBus());

		ITEMS.register(modBus);
	}
}
