<?php

// This file has been auto-generated by the Symfony Dependency Injection Component for internal use.

if (\class_exists(\ContainerZn6BiTF\App_KernelDevDebugContainer::class, false)) {
    // no-op
} elseif (!include __DIR__.'/ContainerZn6BiTF/App_KernelDevDebugContainer.php') {
    touch(__DIR__.'/ContainerZn6BiTF.legacy');

    return;
}

if (!\class_exists(App_KernelDevDebugContainer::class, false)) {
    \class_alias(\ContainerZn6BiTF\App_KernelDevDebugContainer::class, App_KernelDevDebugContainer::class, false);
}

return new \ContainerZn6BiTF\App_KernelDevDebugContainer([
    'container.build_hash' => 'Zn6BiTF',
    'container.build_id' => 'b7d0a6d6',
    'container.build_time' => 1675339280,
], __DIR__.\DIRECTORY_SEPARATOR.'ContainerZn6BiTF');
