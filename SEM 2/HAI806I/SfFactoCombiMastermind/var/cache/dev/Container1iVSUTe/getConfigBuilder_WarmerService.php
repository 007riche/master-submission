<?php

namespace Container1iVSUTe;

use Symfony\Component\DependencyInjection\Argument\RewindableGenerator;
use Symfony\Component\DependencyInjection\Exception\RuntimeException;

/**
 * @internal This class has been auto-generated by the Symfony Dependency Injection Component.
 */
class getConfigBuilder_WarmerService extends App_KernelDevDebugContainer
{
    /**
     * Gets the private 'config_builder.warmer' shared service.
     *
     * @return \Symfony\Bundle\FrameworkBundle\CacheWarmer\ConfigBuilderCacheWarmer
     */
    public static function do($container, $lazyLoad = true)
    {
        include_once \dirname(__DIR__, 4).'/vendor/symfony/http-kernel/CacheWarmer/CacheWarmerInterface.php';
        include_once \dirname(__DIR__, 4).'/vendor/symfony/framework-bundle/CacheWarmer/ConfigBuilderCacheWarmer.php';

        return $container->privates['config_builder.warmer'] = new \Symfony\Bundle\FrameworkBundle\CacheWarmer\ConfigBuilderCacheWarmer(($container->services['kernel'] ?? $container->get('kernel', 1)), ($container->privates['logger'] ?? $container->getLoggerService()));
    }
}
