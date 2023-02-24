<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class FactController extends AbstractController
{
    #[Route('/fact/{number}', name: 'app_fact')]
    public function index($number): Response
    {
        return new Response($number);
    }

}
