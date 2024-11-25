package cx.rain.mc.improvisations.handler;

import dev.architectury.event.EventResult;
import dev.architectury.event.events.common.InteractionEvent;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.TamableAnimal;

public class PatPetHandler {
    public static void register() {
        InteractionEvent.INTERACT_ENTITY.register((player, entity, hand) -> {
            if (entity instanceof TamableAnimal tamable) {
                if (player.isShiftKeyDown() && tamable.isTame() && tamable.isOwnedBy(player)) {
                    var level = player.level();
                    for(var i = 0; i < 3; ++i) {
                        var xSpeed = level.random.nextGaussian() * 0.02;
                        var ySpeed = level.random.nextGaussian() * 0.02;
                        var zSpeed = level.random.nextGaussian() * 0.02;
                        level.addParticle(ParticleTypes.HEART, tamable.getRandomX(1), tamable.getRandomY() + 0.5, tamable.getRandomZ(1), xSpeed, ySpeed, zSpeed);
                    }

                    // Todo: prevent player pat to fast heal pets. how about once per 6000 ticks (quarter of a day)? attach on the player
                    var health = tamable.getHealth();
                    var maxHealth = tamable.getMaxHealth();
                    if (health < maxHealth) {
                        // The more hurt, the more heal.
                        // No more than 35% of the max health.
                        // No less than 5% of hurt.
                        // Any better algorithm?
                        var hurt = maxHealth - health;
                        var maxHeal = Math.min(maxHealth * 0.35F, hurt);
                        var minHeal = hurt * 0.05F;
                        var factor = (float) level.random.nextGaussian();
                        var heal = Mth.abs(maxHeal - minHeal) * factor;
                        tamable.heal(heal);
                    }
                }
            }

            return EventResult.pass();
        });
    }
}
