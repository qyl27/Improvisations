package cx.rain.mc.improvisations.handler;

import dev.architectury.event.EventResult;
import dev.architectury.event.events.common.InteractionEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class TakeSaddleOffHandler {
    public static void register() {
        InteractionEvent.INTERACT_ENTITY.register((player, entity, hand) -> {
            if (entity instanceof Pig pig) {
                if (player.isShiftKeyDown() && pig.isSaddled() && player.getItemInHand(hand).isEmpty()) {
                    pig.steering.setSaddle(false);
                    player.level().playSound(null, pig, SoundEvents.PIG_SADDLE, player.getSoundSource(), 0.5F, 1.0F);
                    player.addItem(new ItemStack(Items.SADDLE));
                    return EventResult.interruptTrue();
                }
            }

            return EventResult.pass();
        });
    }
}
